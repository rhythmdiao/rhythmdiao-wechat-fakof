# rhythmdiao-fakof
*   java版本的微信订阅号后台
*   使用spring boot架构快速开发和部署
*   目前使用花生壳+个人机器搭建服务器

#Build Status [![Build Status](https://www.travis-ci.org/rhythmdiao/rhythmdiao-fakof.svg?branch=master)](https://www.travis-ci.org/rhythmdiao/rhythmdiao-fakof)

#Features
*   封装中控服务器，定时获取access_token
*   封装API-proxy服务器，对接微信订阅号API(个人未认证号接口权限很少)
*   封装Inner服务器，实现特定的订阅号业务逻辑，主要接收用户文本消息
*   先不接数据库了，用应用级别缓存操作数据

#License
*   Copyright(c) 2018-2018 Yuxing Ma

#Author
*   rhythmdiao@gmail.com
*   If any questions, freely contact me