<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Jsp & Servlet �����ϱ�</h1>
<%
	String name="����";
	
	System.out.println("�� ��� ��µǴ�..??"); // �ܼ�â(����â�� ���)
	
	out.println("�� ������ ����.."); //������ ���
	
	out.println("�������..."); //������ ���
%>

<h3>�ȳ��ϼ��� <%=name %>�Դϴ�.</h3>

<%!

	//�������� or �޼ҵ� ����
	String addr;
	int age=25;
	public String test(String name){
		return name+"�� ���̴�"+age+"��, �ּ�:	"+ addr;
	}

%>
<h2> �޼ҵ� ȣ�� �ϱ�</h2>
<%=test("wangjun") %>
</body>
</html>