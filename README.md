# spring-cloud-spintbootbook
这是一个springboot上面的springcloud的列子


启动的顺序依次是
1、DiscoveryApplication
2、ConfigAPPlication
3、后面服务不区分顺序
4、最后启动MonitorApplication



输入http://localhost:8761/   查看Eureka Server，哪些进行注册的服务

http://localhost/  访问UI服务，也是我们的网关处理，调用person
http://localhost/#/some 调用some服务


http://localhost:8989/hystrix.stream  访问断路器监控
查询的框中填写http://localhost/hystrix.stream   监控本机


然后疯狂点击前面的some和save的界面进行查看断路器的监控，会看到相对应的曲线图


