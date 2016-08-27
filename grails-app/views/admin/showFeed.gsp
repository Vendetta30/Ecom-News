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
            <g:each in="${feedList}" var="feed">
                <div class="post medium-post">

                    <div class="post-content">
                        <div class="entry-meta">
                            <ul class="list-inline">
                                <li class="publish-date">
                                    <a href="#">
                                        <i class="fa fa-clock-o"></i>
                                        ${feed?.pubDate}
                                    </a>
                                </li>
                            </ul>
                        </div>

                        <h2 class="entry-title">
                            <a href="${createLink(controller: 'feed', action: 'show', params: [id: feed?.id, title: feed?.title])}">${feed?.title}</a>
                        </h2>
                    </div>
                </div>
            </g:each>
        </div>
    </div>

</div>
</body>
</html>