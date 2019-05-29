# java-cross-domain
use java resolve cross domain



配置ngnix代理

1 在conf文件夹中增加vhost虚拟主机配置文件夹
2 修改nginx.conf增加配置

include vhost/*.conf

3 在vhost文件夹中增加配置文件

b.com.conf

配置内容

server{
	listen 80;
	server_name b.com;
	location /{
	  proxy_pass http://localhost:8080;
	}
}

4 测试配置文件是否生效
在nginx主目录下打开cmd,输入
nginx.exe -t

5 修改hosts文件映射域名

hosts文件路径
C:\Windows\System32\drivers\etc\hosts

在最后加上127.0.0.1 b.com

6 启动nginx代理
start nginx

nginx –h           //查看nginx的帮助

nginx -s stop    // 停止nginx

nginx -s reload   // 重新加载配置文件

7 测试代理是否成功
http://b.com/test/get1   返回结果和    http://localhost:8080/test/get1(ajaxserver项目中写的测试接口)   返回结果是否相同

8 nginx中增加跨域设置

b.com.conf
内容修改为
server{
	listen 80;
	server_name b.com;
	location /{
	  proxy_pass http://localhost:8080/;

	  add_header Access-Control-Allow-Methods *;
	  add_header Access-Control-Max-Age 3600;
	  add_header Access-Control-Allow-Credentials true;
	  add_header Access-Control-Allow-Origin $http_origin;
	  add_header Access-Control-Allow-Headers 
	  $http_access_control_request_headers;

	  if ($request_method = OPTIONS){
	  	return 200;
	  }
	}
}

9跨域代理测试
启动ajaxclient项目    

