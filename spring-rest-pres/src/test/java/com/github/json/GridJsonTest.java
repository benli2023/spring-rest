package com.github.json;

import java.io.IOException;

import junit.framework.TestCase;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.util.Assert;

import com.github.springrest.base.GridEditorJsonData;
import com.github.springrest.propertyeditor.GridJsonPropertyEditor;

public class GridJsonTest extends TestCase {

	private String jsonContent="{\"update\":[{\"stockOperationId\":1,\"stockOperDetailId\":1,\"productId\":\"5\",\"stockOperationIdTxt\":\"出库\",\"productIdTxt\":\"7544\",\"haveInvoice\":1,\"invoiceNumber\":\"121212121\",\"price\":12,\"quantity\":12}],\"insert\":[{\"productId\":\"8\",\"productIdTxt\":\"商品名称\",\"price\":\"112\",\"quantity\":\"12\",\"haveInvoice\":\"\",\"invoiceNumber\":\"111\"}],\"delete\":[]}";
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		
	}
	
	public void testJson() {
		GridEditorJsonData<StockRecordLine> data=null;
		try {
			data=mapper.readValue(jsonContent, new TypeReference<GridEditorJsonData<StockRecordLine>>() {});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.notNull(data);
	}
	
	@SuppressWarnings("unchecked")
	public void testPropertyEditor() {
		
		GridJsonPropertyEditor GridJsonPropertyEditor=new GridJsonPropertyEditor();
		GridJsonPropertyEditor.setObjectMapper(mapper);
		
		GridJsonPropertyEditor.setAsText(jsonContent);
		
		GridEditorJsonData<StockRecordLine> data=(GridEditorJsonData<StockRecordLine>)GridJsonPropertyEditor.getValue();
		
		data.getUpdate();
	}
	
	
}
