<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <#if messageBool??!><<div class="alert alert-dismissible alert-success">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <#if message??>
            <strong>${message}</strong>
        </#if>
        </div>
    </#if>
<@l.login "/login" false/>

</@c.page>
