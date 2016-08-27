<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>

<body>
<div class="container-fluid">

    <div class="section">
        <div class="row">
            <g:render template="/home/latestNews"/>
            <g:render template="/home/topNews"/>
            <g:render template="/home/mostPopular"/>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
                var refreshId = setInterval(function () {
                    var url = '${createLink(controller: 'home', action: 'refresh', absolute: true)}';
                    $.ajax({
                        url: url,
                        datatype: 'json',
                        type: 'POST',
                        success: function (response) {
                        },
                        error: function (data) {
                            emptyForm();
                        }
                    });
                }, 10000 * 60 * 3);
            }
    )
</script>
</body>
</html>
