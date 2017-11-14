# css-elasticsearch
关于Elasticsearch中jar依赖与业务项目jar包的冲突的完美解决，并扩展HTTP、Rest、Transport接口

解决一下jar包冲突：

1.log4j2

2.jackson

3.io.netty以及jboss.netty

4.fastjson

## 使用方式：

1. Maven配置

```xml
<dependency>
    <groupId>com.ucloudlink.css</groupId>
    <artifactId>css-elasticsearch</artifactId>
    <version>5.x.x</version>
</dependency>
```

2.业务集成重写common/BaseUtil.java即可
