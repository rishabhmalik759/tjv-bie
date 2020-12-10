<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="mb-1">Registration</div>
<#if errorMessage??!><div class="alert alert-dismissible alert-danger">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <#if message??>
        <strong>${message}</strong>
    </#if>
</div></#if>
<@l.login "/registration" true />
</@c.page>
