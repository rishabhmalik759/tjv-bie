<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <div class="col-sm-3">
            <input type="text" name="username" class="form-control" placeholder="Username" />
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-3">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
    <#if isRegisterForm>
    <div class="form-group">
        <select class="col-sm-2 form-control" name="role">
            <option value="user">User</option>
            <option value="racer">Racer</option>
        </select>
    </div>
    </#if>
    <#if _csrf??>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </#if>
    <#if !isRegisterForm><a href="/registration">Registration</a></#if>
    <button class="btn btn-primary" type="submit">  <#if isRegisterForm>Register<#else>Sign In</#if></button>
</form>
</#macro>

<#include "security.ftl">
<#macro logout>
    <form action="/logout" method="post">
    <#if _csrf??>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </#if>
    <#if known> <button class="btn btn-primary" type="submit">Sign Out</button> </#if>
</form>
<form action="/login" method="get">
    <#if _csrf??>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </#if>

    <#if !known> <button class="btn btn-primary" type="submit">Sign In</button> </#if>
</form>
</#macro>
