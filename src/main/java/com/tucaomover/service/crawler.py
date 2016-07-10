# -*- coding: utf-8 -*-

#crawling from 北美吐槽君, get original posts and their hot comments

import urllib2, cookielib
import requests
import os
from bs4 import BeautifulSoup,Comment
import json
import re
import sys
from models import Gossip, Comment,database
import peewee
import hashlib
from datetime import datetime

cookie = {"Cookie": "_T_WM=1ce0a62ce378be962ef0a1ecfec7a803; SCF=ArBUQatDHi1MvA1NXWXr1dN-Tj0yesHomW_oMvIeOHh-jAFLPppeBwwO6K8cJyoVmcdN6cfYtXr1Rpznld_4H4Y.; SUHB=0sqQB9pVaAadTw; SUB=_2A256eS80DeTxGedP7VUV8ifEyTuIHXVZhbF8rDV6PUJbkdAKLXn7kW2EHYN-soM04Z-VLWKppHGT23enPA..; gsid_CTandWM=4ujJ18071QGPco50sSOQf4THvdl"}
url = "http://weibo.cn/shenqiUSA?filter=1"
#'http://m.weibo.cn/page/tpl?containerid=1005053177527181_-_WEIBO_SECOND_PROFILE_WEIBO&itemid=&title=%E5%85%A8%E9%83%A8%E5%BE%AE%E5%8D%9A' 



re_com=re.compile(ur'评论\[(.*?)\]',re.UNICODE)
re_repo=re.compile(ur'转发\[(.*?)\]',re.UNICODE)
re_up=re.compile(ur'赞\[(.*?)\]',re.UNICODE)
re_image=re.compile(ur'原图',re.UNICODE)



#TODO: wrap with try
html = requests.get(url, cookies=cookie).content
soup = BeautifulSoup(html,"lxml")
cards = soup.find_all('div',{'class': 'c'})


#find original posts
ori_crads=[]
for card in cards:
	if not card.find('span',{'class': 'cmt'}) and card.has_attr('id'):
		ori_crads.append(card)

database.connect()
for card in ori_crads:
	#post id
	pid=card['id'][2:]
	print pid
	#post text
	text = card.find('span',{'class': 'ctt'}).getText().encode('utf-8')
	print text
	#test if have a image
	try:
		image_small = card.find('img')['src']
	except Exception :
		continue
	
	image=image_small.replace('wap180','large')

	print image
		
	up = int(re_up.findall(card.getText())[0].encode('utf-8'))
	repost = int(re_repo.findall(card.getText())[0].encode('utf-8'))
	comment = int(re_com.findall(card.getText())[0].encode('utf-8'))
	

	try:
		tucao = Gossip.get(Gossip.id==pid)
		tucao.commentnum=comment;
		tucao.forwardnum=repost;
		tucao.upnum=up;
		tucao.imageurl=image;
		tucao.text=text; 
		print tucao.save()
	except Gossip.DoesNotExist:		
		
		tucao= Gossip(id=pid, commentsnum=comment, forwardnum=repost, upnum=up,imageurl=image, text=text, timeretrieved=datetime.now() )
		print tucao.save(force_insert=True)

	hotComments = []
	hc_url = 'http://weibo.cn/comment/hot/'+pid
	html_hc = requests.get(hc_url,cookies =cookie).content
	soup_hc = BeautifulSoup(html_hc,"lxml")
	comments = soup_hc.find_all('div', {'class': 'c'})
	for c in comments:
		if c.has_attr('id'):
			cid = c['id'][2:]
			c_text = c.find('span',{'class': 'ctt'}).getText().encode('utf-8')
			comment=Comment(id=cid,content=c_text,gossip=pid)
			try:
				Comment.get(Comment.id==cid)
				print 'comment update', comment.save()
			except Comment.DoesNotExist:
				print 'coment',comment.save(force_insert=True)


			
database.close()	












# soup = BeautifulSoup(html,"lxml")
# json_str=""
# content = soup.find_all('script')
# for x in content:
# 	text=x.getText().encode('utf-8')	
# 	re_s = re.compile(r'window\.\$render_data =(.*?);')
# 	match=re_s.findall(text)
# 	for x in match:
# 		json_str+=x+'\n'
# json_str=json_str.replace('\'','\"')
# print json_str
# js=json.loads(json_str)




