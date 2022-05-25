1. what is the difference between HTTP and HTTPS
HTTPS 和 HTTP

HTTPS 协议需要申请证书
HTTP 和 HTTPS 使用端口不一样，前者是80，后者是443
HTTP 协议运行在 TCP 之上，所有传输的内容都是明文，HTTPS 运行在 SSL/TLS 之上，SSL/TLS运行在TCP之上，所有传输的内容都经过加密的
HTTPS 可以有效的防止运营商劫持


2. what is the difference between HTTP1.0 and HTTP1.1
https://juejin.cn/post/6844903923136856078
HTTP 1.1 是在 1.0 发布之后的半年就推出了，完善了 1.0 版本。目前也还有很多的互联网项目基于 HTTP 1.1 在向外提供服务。
特性

长连接：新增Connection字段，可以设置keep-alive值保持连接不断开
管道化：基于上面长连接的基础，管道化可以不等第一个请求响应继续发送后面的请求，但响应的顺序还是按照请求的顺序返回
缓存处理：新增字段cache-control
断点传输



