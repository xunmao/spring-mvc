function toPostMethod(node) {
    $.ajax({
        url: node.href,
        type: 'POST',
        success: function (result) {
            if (result) {
                window.location.reload();
            } else {
                console.error("没有返回结果");
                console.error("节点的URL: " + url);
                console.error("窗口的URL: " + window.location.href);
            }
        }
    });
}
