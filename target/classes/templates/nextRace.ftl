<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <#if ok??!>
    <#if user.isRacer()>
        <form action="/registerToRace" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Register to race</button>
        </form>
    </#if>

    <h2 class="mt-2">The next race is ${nextRace.date}</h2>
    <table class="table table-hover mt-5">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Car</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#if registrations??>
            <#list registrations as registration>
                <tr>
                    <td>${registration.racer.user.username}</td>
                    <td>${registration.getCar().brand} ${registration.getCar().model}</td>
                    <td><a href="/racers/stats/${registration.racer.id}">racer statistics</a></td>
                    <td><a href="/makeBet/${registration.id}">make a bet</a></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <#else> <h1>Sorry :(</h1>
    </#if>
</@c.page>
