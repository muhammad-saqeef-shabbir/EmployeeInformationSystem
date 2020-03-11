(function () {
    'use strict';

    angular
        .module('app')
        .controller('EmployeesController', EmployeesController)

    EmployeesController.$inject = ['$http', '$scope', '$filter'];

    function EmployeesController($http, $scope, $filter) {
        var ec = this;

        ec.employees = [];
        $scope.employee = {};
        ec.getAll = getAll;
        ec.deleteEmployee = deleteEmployee;
        ec.addEmployee = addEmployee;
        ec.editEmployee = editEmployee;
        $scope.setEmployee = setEmployee;
        ec.updateEmployee = updateEmployee;

        init();

        function init() {
            /*$(document).ready(function () {
                $('#employeesTable').DataTable();
            });*/

            getAll();
        }

        function getAll() {
            var url = "/api/v1/employee/all";
            var employeesInfo = $http.get(url);
            employeesInfo.then(function (response) {
                ec.employees = response.data;
            });
        }

        function deleteEmployee(id) {
            var url = "/api/v1/employee/delete/" + id;
            $http.get(url).then(function (response) {
                ec.employees = response.data;
            });
        }

        function addEmployee(employee) {
            var url = "/api/v1/employee/add";
            var rowsAffected = {};

            $http.post(url, employee).then(function (response) {
                rowsAffected = response.data;
                location.href='/Home/Index';
            });

        }

        function editEmployee(id) {
            var url = "/Home/Edit/";
            location.href = url + id;
        }

        function setEmployee(id) {
            var url = "/api/v1/employee/" + id;
            var employeeInfo = $http.get(url);
            employeeInfo.then(function (response) {
                $scope.employee = response.data;
                $scope.employee.dob = new Date($scope.employee.dob);
            });
        }

        function updateEmployee(employee) {
            var url = "/api/v1/employee/update/";
            var rowsAffected = {};

            $http.put(url, employee).then(function (response) {
                rowsAffected = response.data;
                location.href='/Home/Index';
            });
        }
    }
})();