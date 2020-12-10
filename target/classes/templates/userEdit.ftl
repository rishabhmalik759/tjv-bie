<#import "parts/common.ftl" as c>

<@c.page>
User editor

    <form action="/user" method="post">
        <#if username??>
            <input type="text" name="username" value="${user.username}">
        </#if>
        <#if roles??>
            <#list roles as role>
                <div>
                    <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                </div>
            </#list>
        </#if>
        <#if user??>
            <input type="hidden" value="${user.id}" name="userId">
        </#if>
        <#if _csrf??>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </#if>
    <button type="submit">Save</button>
</form>
</@c.page>
