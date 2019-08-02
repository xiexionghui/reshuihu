var XMLHttpReq;  
function createXMLHttpRequest() {  
    try {  
        XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");//IE高版本创建XMLHTTP  
    }  
    catch(E) {  
        try {  
            XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");//IE低版本创建XMLHTTP  
        }  
        catch(E) {  
            XMLHttpReq = new XMLHttpRequest();//兼容非IE浏览器，直接创建XMLHTTP对象  
        }  
    }  
  
}  




//回调函数  
function backResponse() {  
    if (XMLHttpReq.readyState == 4) {  
        if (XMLHttpReq.status == 200) {  
            var text = XMLHttpReq.responseText;  
            $("#back").html(text);
        }  
    }  
  
}  