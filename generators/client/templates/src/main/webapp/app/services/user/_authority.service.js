(function () {
    'use strict';

    angular
        .module('<%=angularAppName%>')
        .factory('Authority', Authority);

    Authority.$inject = ['$resource'];

    function Authority ($resource) {
        var service = $resource(<% if(authenticationType === 'uaa') { %>'<%= uaaBaseName.toLowerCase() %>/api/authority/getAll'<%} else { %>'api/authority/getAll'<% } %>, {}, {
            'getAll': {method: 'GET', isArray: true}
        });

        return service;
    }
})();
