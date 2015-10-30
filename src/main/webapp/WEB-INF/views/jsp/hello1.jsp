<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html ng-app="mainApp">
    <head>
        <title>mehdi angular page</title>
        <script src="<spring:url value="/resources/core/js/angularjs/angular.min.js" />"></script>
        <script>
            var app = angular.module('mainApp', []);
            app.controller('mehdiController', function ($scope, $http) {
                $http.get('<spring:url value="/rest/person/list" />').success(function (data) {
                    $scope.persons = data;
                });
            });
        </script>
        <style>
         table, th , td {
            border: 1px solid grey;
            border-collapse: collapse;
            padding: 5px;
         }
         
         table tr:nth-child(odd) {
            background-color: #f2f2f2;
         }
         
         table tr:nth-child(even) {
            background-color: #ffffff;
         }
      </style>
     
    </head>
    <body ng-controller="mehdiController">
        <h1>Hello {{message}} !</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>name</th>
                <th>Country</th>
            </tr>
            <tr ng-repeat="person in persons">
                <td>{{person.is}}</td>
                <td>{{person.name}}</td>
                <td>{{person.country}}</td>
            </tr>
        </table>                
    </body>
</html>