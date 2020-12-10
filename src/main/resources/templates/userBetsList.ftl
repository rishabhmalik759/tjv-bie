<#import "parts/common.ftl" as c>

<@c.page>
    <h2>Your bets</h2>

    <table class="table table-hover mt-5">
        <thead>
        <tr>
            <th scope="col">Date</th>
            <th scope="col">Amount</th>
            <th scope="col">Rate</th>
        </tr>
        </thead>
        <tbody>
        <#if bets??>
            <#list bets as bet>
                <tr>
                    <td>${bet.date}</td>
                    <td>${bet.amount}</td>
                    <td>${bet.rate}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
