/**
 * 
 */
package eu.cloudopting.tosca.nodes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import eu.cloudopting.tosca.transformer.ToscaFileManager;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * @author gioppo
 *
 */
public class PostgreSQLDatabase implements CloudOptingNode {
	@Autowired
	ToscaFileManager tfm;
	/* (non-Javadoc)
	 * @see eu.cloudopting.tosca.nodes.CloudOptingNode#prepare(java.lang.String)
	 */
	@Override
	public String prepare(HashMap<String, String> data) {
		String id = data.get("id");
		System.out.println("Working on :"+id);
		tfm = ToscaFileManager.getInstance();
		// TODO the ClearoPostgreSQLDB must be passes in the hash
		String myTemplate = tfm.getTemplateForNode("ClearoPostgreSQLDB","PuppetTemplate");
		System.out.println("The template is :"+myTemplate);
		Map nodeData = tfm.getPropertiesForNode(id);
		Configuration cfg = new Configuration();
		Template tpl = null;
		try {
			tpl = cfg.getTemplate(myTemplate+".ftl");
		} catch (TemplateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
StringWriter writer = new StringWriter();
//		OutputStreamWriter outputTempl = new OutputStreamWriter(System.out);
		try {
//			tpl.process(nodeData, outputTempl);
			tpl.process(nodeData, writer);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return writer.getBuffer().toString();
	}

}