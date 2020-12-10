<#import "parts/common.ftl" as c>

<@c.page>
    <h2>List of racers</h2>

    <table class="table table-hover mt-5">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Wins</th>
        </tr>
        </thead>
        <tbody>
        <#if racers??>
            <#list racers as racer>
                <tr>
                    <td>${racer.user.username}</td>
                    <td>${racer.winCounter}</td>
                    <td><a href="/racers/stats/${racer.id}">statistics</a></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
