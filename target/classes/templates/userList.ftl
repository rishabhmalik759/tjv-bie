<#import "parts/common.ftl" as c>

<@c.page>

<h2>List of users</h2>

<table class="table table-hover mt-5">

    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Role</th>
        <th scope="col">Account</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <#if users??>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <#if user.isRacer()> <td> Racer</td>
                <#elseif user.isAdmin()> <td> Admin </td>
                <#else> <td> User </td>
                </#if>
                <td>${user.account}</td>
                <td><a href="/users/${user.id}">edit</a></td>
            </tr>
        </#list>
    </#if>
    </tbody>
</table>
</@c.page>
