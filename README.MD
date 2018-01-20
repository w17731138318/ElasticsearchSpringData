# ElasticsearchSpringData
## 配置Elasticsearch集群
### 目前spring boot只支持Elasticsearch2.4.x版本

采用Elasticsearch2.4.6版本
解压复制三份：
1. elasticsearch-cluster：

    作为master
    在config/elasticsearch.yml文件末尾追加
    
    > http.cors.enabled: true  
      http.cors.allow-origin: "*"  
      cluster.name: myelasticsearch  
      node.name: master  
      node.master: true  
      network.host: 127.0.0.1
         
    说明：  
    http.cors.enabled：启动跨越  
    http.cors.allow-origin: "*"  允许任何请求
    cluster.name：集群名称  
    node.name: 几点名  
    node.master: 是否master    
    network.host: hostIP
    
2. elasticsearch-slave-1:

    子节点slave-1
    在config/elasticsearch.yml文件末尾追加
    > cluster.name: myelasticsearch  
      node.name: slave1  
      network.host: 127.0.0.1  
      http.port: 9201  
      discovery.zen.ping.unicast.hosts: ["127.0.0.1"]  
  
    说明：  
        http.port: 节点端口    
        discovery.zen.ping.unicast.hosts:["127.0.0.1"]自动发现和Master节点的选举   
        
3. elasticsearch-slave-2

    子节点slave-2
    ..同上,只需修改端口和节点名称
## 配置springboot

>spring.data.elasticsearch.cluster-name=myelasticsearch  
spring.data.elasticsearch.cluster-nodes=127.0.0.1:9300  
spring.data.elasticsearch.repositories.enabled=true  

## 备注：为了统一版本号，Elasticsearch从2.x直接跳到了5.x 
2和5没有太大区别