<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Night Prague Street Racing</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <#if known><a class="nav-link" href="/myBets">My bets</a> </#if>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/nextRace">Next race</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/racers">Racer list</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/users">User list</a>
            </li>
            </#if>
        </ul>

        <#if known> <div class="navbar-text mr-3">${name}</div>
                    <div class="navbar-text mr-3">Account: ${account}</div>
        </#if>
        <@l.logout />
    </div>
</nav>
