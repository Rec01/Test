var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "50000",
        "ok": "50000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "4",
        "ok": "4",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "8036",
        "ok": "8036",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1102",
        "ok": "1102",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "959",
        "ok": "959",
        "ko": "-"
    },
    "percentiles1": {
        "total": "850",
        "ok": "850",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1137",
        "ok": "1137",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2904",
        "ok": "2904",
        "ko": "-"
    },
    "percentiles4": {
        "total": "6078",
        "ok": "6078",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 20299,
    "percentage": 41
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 19052,
    "percentage": 38
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 10649,
    "percentage": 21
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "877.193",
        "ok": "877.193",
        "ko": "-"
    }
},
contents: {
"req_createentitytes-47cd1": {
        type: "REQUEST",
        name: "createEntityTest",
path: "createEntityTest",
pathFormatted: "req_createentitytes-47cd1",
stats: {
    "name": "createEntityTest",
    "numberOfRequests": {
        "total": "50000",
        "ok": "50000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "4",
        "ok": "4",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "8036",
        "ok": "8036",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1102",
        "ok": "1102",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "959",
        "ok": "959",
        "ko": "-"
    },
    "percentiles1": {
        "total": "850",
        "ok": "850",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1137",
        "ok": "1137",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2904",
        "ok": "2904",
        "ko": "-"
    },
    "percentiles4": {
        "total": "6078",
        "ok": "6078",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 20299,
    "percentage": 41
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 19052,
    "percentage": 38
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 10649,
    "percentage": 21
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "877.193",
        "ok": "877.193",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
