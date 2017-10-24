package com.ucloudlink.css.elasticsearch;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AnalysisRegistry;
import org.elasticsearch.index.analysis.CharFilterFactory;
import org.elasticsearch.index.analysis.IndexAnalyzers;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;

import com.alibaba.fastjson.JSONObject;
import com.ucloudlink.css.common.DataSourceUtil;
import com.ucloudlink.css.elasticsearch.http.ElasticsearchHttpFactory;
import com.ucloudlink.css.elasticsearch.rest.ElasticsearchRestFactory;
import com.ucloudlink.css.elasticsearch.transport.ElasticsearchTransportFactory;

public class ElasticsearchTest {
	private static ElasticsearchTransportFactory tfactory = DataSourceUtil.transportElasticsearch();
	private static ElasticsearchHttpFactory hfactory = DataSourceUtil.httpElasticsearch();
//	private static ElasticsearchRestFactory rfactory = DataSourceUtil.restElasticsearch();
	public static void test(){
		JSONObject json = new JSONObject();
		json.fluentPut("id", 1).fluentPut("name", "user").fluentPut("price", 2.36).fluentPut("flag", true);
		json.fluentPut("datetime", new Date()).fluentPut("array", new String[]{"11","22"}).fluentPut("chara", 'a').fluentPut("obj", new Object());
		hfactory.insert("test", "json", json.toJSONString());
	}
	public static void test1() throws Exception{
		String analyze = "{\"settings\":{\"analysis\":{\"filter\":{\"default_stopwords\":{\"type\":\"stop\",\"stopwords\":[\"a\",\"an\",\"and\",\"are\",\"as\",\"at\",\"be\",\"but\",\"by\",\"for\",\"if\",\"in\",\"into\",\"is\",\"it\",\"no\",\"not\",\"of\",\"on\",\"or\",\"such\",\"that\",\"the\",\"their\",\"then\",\"there\",\"these\",\"they\",\"this\",\"to\",\"was\",\"will\",\"with\"]}},\"char_filter\":{\"symbol_transform\":{\"mappings\":[\"&=> and \",\"||=> or \"],\"type\":\"mapping\"}},\"analyzer\":{\"es_analyzer\":{\"filter\":[\"lowercase\",\"default_stopwords\"],\"char_filter\":[\"html_strip\",\"symbol_transform\"],\"type\":\"custom\",\"tokenizer\":\"standard\"}}}}}";
		Settings settings = Settings.builder().loadFromSource(analyze, XContentType.JSON).build();
//		AnalysisRegistry registry = new AnalysisModule(new Environment(settings), Collections.singletonList(new AnalysisPlugin() {
//			 	@Override
//	            public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
//	                return AnalysisPlugin.super.getTokenFilters();
//	            }
//			 	@Override
//			 	public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
//			 		return AnalysisPlugin.super.getTokenizers();
//			 	}
//	            @Override
//	            public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
//	                return AnalysisPlugin.super.getCharFilters();
//	            }
//		} )).getAnalysisRegistry();
//		IndexSettings idxSettings = new IndexSettings(IndexMetaData.builder("test").build(), settings);
//		IndexAnalyzers indexAnalyzers = registry.build(idxSettings);
		CreateIndexResponse response = tfactory.getClient().admin().indices().prepareCreate("thr2").setSettings(settings).get();
		System.out.println(response.isAcknowledged());
	}
	public static void main(String[] args) throws Exception {
		String result = "";
//		result = hfactory.indices();
//		System.out.println(result);
//		System.out.println("---------------------------------------------------------------------------------");
//		result = rfactory.indices();
//		System.out.println(result);
//		System.out.println("---------------------------------------------------------------------------------");
//		result = tfactory.indices();
//		System.out.println(result);
//		System.exit(1);
		test1();
//		result = tfactory.es_analyzer("thr1");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------------------");
		System.exit(1);
	}

}
