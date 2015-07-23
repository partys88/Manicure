# Manicure
A WeChat server

###	Server API
http://domain/Manicure/api/keystone/core/

###	Menu API
##### create
http://domain/Manicure/api/keystone/menu/create 

###	User API
##### Get SNS user
http://domain/Manicure/api/keystone/user/query/sns/{openId}/{accessToken}
##### SNS user OAuth
http://domain/Manicure/api/keystone/user/sns/oauth 
##### Get WeChat user
http://domain/Manicure/api/keystone/user/query/{openId} 
##### Get WeChat user (Query from the very beginning of the list when {nextOpenId} is 0)
http://domain/Manicure/api/keystone/user/list/{nextOpenId}

###	Material API
##### Get material
http://domain/Manicure/api/keystone/material/query/{mediaId}
##### Get material list
http://domain/Manicure/api/keystone/material/list



###	Mobile web page
##### Index
http://domain/Manicure/mobile/
http://domain/Manicure/mobile/index
##### Home
http://domain/Manicure/mobile/home
##### Service choose
http://domain/Manicure/mobile/service
##### Order list
http://domain/Manicure/mobile/order
##### Service list
http://domain/Manicure/mobile/list

