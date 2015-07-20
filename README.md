# Manicure
A WeChat server

###	Server API
http://domain/Manicure/api/keystone/core/

###	Menu API
##### create
http://domain/Manicure/api/keystone/menu/create 

###	User API
##### SNS user query
http://domain/Manicure/api/keystone/user/query/sns/{openId}/{accessToken}
##### SNS user OAuth
http://domain/Manicure/api/keystone/user/sns/oauth 
##### WeChat user query
http://domain/Manicure/api/keystone/user/query/{openId} 
##### WeChat user list (Query from the very beginning of the list when {nextOpenId} is 0)
http://domain/Manicure/api/keystone/user/list/{nextOpenId}