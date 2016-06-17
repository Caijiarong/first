jQuery.send = function(action,method,json){
	data : null,
	jQuery.ajax({
		url : action + "?method=" + method,
		type : "GET",
		async : false,
		data : {"param" : JSON.stringify(json)},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "text",
        cache: true,
        success: function (data) {
            //返回的数据用data.d获取内容
            jQuery.send.data = parseJSON(data);
        },
        error: function (err) {
            alert("您发送的请求没有相应，请与系统管理员联系");
            return err;
        }
	});
	return jQuery.send.data;													//返回的数据
}

function parseJSON(string){
	try {
		return eval('(' + string + ')');
	} catch (e) {
		throw new SyntaxError("解析JSON字符串;出错");
	}
}