# Manicure
A WeChat server

###	Server API
http://www.mydomain.com/api/keystone/core/

###	Menu API
##### create
http://www.mydomain.com/api/keystone/menu/create 

###	User API
##### Get SNS user
http://www.mydomain.com/api/keystone/user/query/sns/{openId}/{accessToken}
##### SNS user OAuth
http://www.mydomain.com/api/keystone/user/sns/oauth 
##### Get WeChat user
http://www.mydomain.com/api/keystone/user/query/{openId} 
##### Get WeChat user (Query from the very beginning of the list when {nextOpenId} is 0)
http://www.mydomain.com/api/keystone/user/list/{nextOpenId}

###	Material API
##### Get material
http://www.mydomain.com/api/keystone/material/query/{mediaId}
##### Get material list
http://www.mydomain.com/api/keystone/material/list

###	Shop API
##### Get shop (Request Method GET)
http://www.mydomain.com/api/keystone/shop/query/{poiId}
##### Get shop list  (Request Method GET)
http://www.mydomain.com/api/keystone//shop/list/{begain}/{limit}

###	Mobile web page
##### Index
http://www.mydomain.com/mobile/
http://www.mydomain.com/mobile/index
##### Home
http://www.mydomain.com/mobile/home
##### Service choose
http://www.mydomain.com/mobile/service
##### Order list
http://www.mydomain.com/mobile/order
##### Service list
http://www.mydomain.com/mobile/list

