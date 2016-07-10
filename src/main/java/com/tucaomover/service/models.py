from peewee import *

#database = MySQLDatabase('gossip', port=3306, user="root")
database = MySQLDatabase('tucaomover',host='127.10.142.2',port=3306, user='adminPFA3p5H', password='VDEiHTuhBKSd')

class UnknownField(object):
    pass

class BaseModel(Model):
    class Meta:
        database = database

class Gossip(BaseModel):
    commentsnum = BigIntegerField(db_column='commentsNum', null=True)
    forwardnum = BigIntegerField(db_column='forwardNum', null=True)
    id = CharField(primary_key=True)
    imageurl = CharField(db_column='imageURL', null=True)
    text = CharField(null=True)
    timeretrieved = DateTimeField(db_column='timeRetrieved', null=True)
    upnum = BigIntegerField(db_column='upNum', null=True)

    class Meta:
        db_table = 'Gossip'

class Comment(BaseModel):
    content = CharField(null=True)
    gossip = ForeignKeyField(db_column='gossip_id', null=True, rel_model=Gossip, to_field='id')
    id = CharField(primary_key=True)

    class Meta:
        db_table = 'Comment'

class User(BaseModel):
    email = CharField(unique=True)
    id = BigIntegerField(primary_key=True)
    password = CharField()
    username = CharField()

    class Meta:
        db_table = 'User'

class UserGossip(BaseModel):
    gossip = ForeignKeyField(db_column='gossip_id', rel_model=Gossip, to_field='id')
    user = ForeignKeyField(db_column='user_id', rel_model=User, to_field='id')

    class Meta:
        db_table = 'user_gossip'
        indexes = (
            (('gossip', 'user'), True),
        )
        primary_key = CompositeKey('gossip', 'user')

