package com.ucloudlink.css.common;

import com.ucloudlink.css.elasticsearch.http.ElasticsearchHttpFactory;
import com.ucloudlink.css.elasticsearch.rest.ElasticsearchHighRestFactory;
import com.ucloudlink.css.elasticsearch.rest.ElasticsearchRestFactory;
import com.ucloudlink.css.elasticsearch.transport.ElasticsearchTransportFactory;
import com.ucloudlink.css.util.StringUtil;
/**
 * @decription 配置文件获取数据源工厂
 * @author yi.zhang
 * @time 2017年7月31日 下午12:03:10
 * @since 1.0
 * @jdk	1.8
 */
public class DataSourceUtil {
	
	/**
	 * @decription Elasticsearch配置[Http接口]
	 * @author yi.zhang
	 * @time 2017年7月31日 下午12:03:45
	 * @return
	 */
	public static ElasticsearchHttpFactory httpElasticsearch(){
		try {
			String clusterName = ElasticConfig.getProperty("elasticsearch.cluster.name");
			String servers = ElasticConfig.getProperty("elasticsearch.cluster.servers");
			String username = ElasticConfig.getProperty("elasticsearch.cluster.username");
			String password = ElasticConfig.getProperty("elasticsearch.cluster.password");
			String port = ElasticConfig.getProperty("elasticsearch.http.port");
			ElasticsearchHttpFactory factory = new ElasticsearchHttpFactory(clusterName, servers, username, password);
			if(!StringUtil.isEmpty(port))factory = new ElasticsearchHttpFactory(clusterName, servers, username, password,Integer.valueOf(port));
			factory.init();
			return factory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @decription Elasticsearch配置[Http接口]
	 * @author yi.zhang
	 * @time 2017年7月31日 下午12:03:45
	 * @return
	 */
	public static ElasticsearchRestFactory restElasticsearch(){
		try {
			String clusterName = ElasticConfig.getProperty("elasticsearch.cluster.name");
			String servers = ElasticConfig.getProperty("elasticsearch.cluster.servers");
			String username = ElasticConfig.getProperty("elasticsearch.cluster.username");
			String password = ElasticConfig.getProperty("elasticsearch.cluster.password");
			String port = ElasticConfig.getProperty("elasticsearch.http.port");
			ElasticsearchRestFactory factory = new ElasticsearchHighRestFactory(clusterName, servers, username, password);
			if(!StringUtil.isEmpty(port))factory = new ElasticsearchHighRestFactory(clusterName, servers, username, password,Integer.valueOf(port));
			factory.init();
			return factory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @decription Elasticsearch配置[java接口]
	 * @author yi.zhang
	 * @time 2017年7月31日 下午12:03:45
	 * @return
	 */
	public static ElasticsearchTransportFactory transportElasticsearch(){
		try {
			String clusterName = ElasticConfig.getProperty("elasticsearch.cluster.name");
			String servers = ElasticConfig.getProperty("elasticsearch.cluster.servers");
			String username = ElasticConfig.getProperty("elasticsearch.cluster.username");
			String password = ElasticConfig.getProperty("elasticsearch.cluster.password");
			String port = ElasticConfig.getProperty("elasticsearch.transport.port");
			ElasticsearchTransportFactory factory = new ElasticsearchTransportFactory(clusterName, servers, username, password);
			if(!StringUtil.isEmpty(port))factory = new ElasticsearchTransportFactory(clusterName, servers, username, password,Integer.valueOf(port));
			factory.init();
			return factory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
