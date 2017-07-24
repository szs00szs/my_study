**使用wsimport生成客户端java类**
> wsimport -keep -p cc http://192.168.1.124:1533/ws/shi?wsdl

使用生成的客户端调用服务
```

<definitions xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsp="http://www.w3.org/ns/ws-policy" xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://support.ws.integration.server.odb.product.uinnova.com/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://schemas.xmlsoap.org/wsdl/" targetNamespace="http://support.ws.integration.server.odb.product.uinnova.com/" name="WSServiceImplService">
<types>
<xsd:schema>
<xsd:import namespace="http://support.ws.integration.server.odb.product.uinnova.com/" schemaLocation="http://192.168.1.124:1533/ws/shi?xsd=1"/>
</xsd:schema>
</types>
<message name="call">
<part name="parameters" element="tns:call"/>
</message>
<message name="callResponse">
<part name="parameters" element="tns:callResponse"/>
</message>
<portType name="WSServiceImpl">
<operation name="call">
<input wsam:Action="http://support.ws.integration.server.odb.product.uinnova.com/WSServiceImpl/callRequest" message="tns:call"/>
<output wsam:Action="http://support.ws.integration.server.odb.product.uinnova.com/WSServiceImpl/callResponse" message="tns:callResponse"/>
</operation>
</portType>
<binding name="WSServiceImplPortBinding" type="tns:WSServiceImpl">
<soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document"/>
<operation name="call">
<soap:operation soapAction=""/>
<input>
<soap:body use="literal"/>
</input>
<output>
<soap:body use="literal"/>
</output>
</operation>
</binding>
<service name="WSServiceImplService">
<port name="WSServiceImplPort" binding="tns:WSServiceImplPortBinding">
<soap:address location="http://192.168.1.124:1533/ws/shi"/>
</port>
</service>
</definitions>
```

**调用**

```
package cc.hansam.java.net.ws.odb;

/**
 * 通过wsimport生成的客户端代码调用webservice服务
 * 
 * @author hansam 945210972@qq.com
 * @date 2017年7月24日下午3:03:19
 */
public class App {

	public static void main(String[] args) {
		WSServiceImplService service = new WSServiceImplService();

		WSServiceImpl po = service.getWSServiceImplPort();

		String call = po.call("");

		System.out.println(call);
	}

}

```