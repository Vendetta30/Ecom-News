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
    </div><!--/.section-->

</div><!--/.container-fluid-->
</body>
</html>
