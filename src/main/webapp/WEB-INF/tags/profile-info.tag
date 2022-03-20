<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<jsp:useBean id="profile" scope="request" type="net.devstudy.resume.entity.Profile"/>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-info-circle"></i> Additional info <a class="edit-block" href="/edit/info">Edit</a>
        </h3>
    </div>
    <div class="panel-body text-justify">${profile.info}</div>
</div>