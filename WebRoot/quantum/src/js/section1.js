/**
 * Created by zhangxingxing on 2016/12/29.
 */

// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('graph1'));


var option = {

    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        },
        formatter:function (params) {
            return  false;

        }
    },

    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: ['13、x品牌','12、x品牌','11、OPPO','10、x品牌','9、x品牌','8、x品牌','7、x品牌','6、x品牌','5、三星','4、小米','3、魅族','2、华为','1、苹果']
    },
    series: [
        {
            name: 'PC端',
            type: 'bar',
            data: [98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98],
            itemStyle:{
                normal: {
                    color:'rgb(122,197,167)'
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'right',
                    formatter: '{c} %'
                }
            }
        },
        {
            name: '移动端',
            type: 'bar',
            data: [76, 76, 76, 76, 76, 76,76,76,76,76,76,76,76],
            itemStyle:{
                normal: {
                    color:'rgb(227,168,160)'
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'right',
                    formatter: '{c} %'
                }
            }
        },
    ]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);


myChart = echarts.init(document.getElementById('graph2'));
option = {

    tooltip : {
        trigger: 'axis'
    },


    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['周一','周二','周三','周四','周五','周六','周日']
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'关注指数',
        }
    ],
    series : [
        {
            name:'PC端',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            itemStyle:{
                normal: {
                    color:'rgb(122,197,167)'
                }
            },

            data:[320, 332, 301, 334, 390, 330, 320]
        },
        {
            name:'移动端',
            type:'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:'rgb(227,168,160)'
                }
            },

            // label: {
            //     normal: {
            //         show: true,
            //         position: 'top'
            //     }
            // },
            areaStyle: {normal: {}},
            data:[820, 932, 901, 934, 1290, 1330, 1320]
        },
        {
            name: '平均值',
            type: 'line',
            data:[400, 500, 408, 655, 700, 500, 600],
            itemStyle:{
                normal: {
                    color:'yellow'
                }
            },
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);


// 基于准备好的dom，初始化echarts实例
myChart = echarts.init(document.getElementById('graph3'));


option = {

    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        },
        formatter:function (params) {
            return  false;
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: ['13、x品牌','12、x品牌','11、OPPO','10、x品牌','9、x品牌','8、x品牌','7、x品牌','6、x品牌','5、三星','4、小米','3、魅族','2、华为','1、苹果']
    },
    series: [
        {
            name: 'PC端',
            type: 'bar',
            data: [98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98],
            itemStyle:{
                normal: {
                    color:'rgb(122,197,167)'
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'right',
                    formatter: '{c} %'
                }
            }
        },
        {
            name: '移动端',
            type: 'bar',
            data: [76, 76, 76, 76, 76, 76,76,76,76,76,76,76,76],
            itemStyle:{
                normal: {
                    color:'rgb(227,168,160)'
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'right',
                    formatter: '{c} %'
                }
            }
        },
    ]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);


myChart = echarts.init(document.getElementById('graph4'));
option = {

    tooltip : {
        trigger: 'axis'
    },

    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['周一','周二','周三','周四','周五','周六','周日']
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'关注指数',
        }


],
    series : [
        {
            name:'PC端',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            itemStyle:{
                normal: {
                    color:'rgb(122,197,167)'
                }
            },
            data:[320, 332, 301, 334, 390, 330, 320]
        },
        {
            name:'移动端',
            type:'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:'rgb(227,168,160)'
                }
            },
            // label: {
            //     normal: {
            //         show: true,
            //         position: 'top'
            //     }
            // },
            areaStyle: {normal: {}},
            data:[820, 932, 901, 934, 1290, 1330, 1320]
        },
        {
            name: '平均值',
            type: 'line',
            data:[400, 500, 408, 655, 700, 500, 600],
            itemStyle:{
                normal: {
                    color:'yellow'
                }
            },
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);


// 基于准备好的dom，初始化echarts实例
myChart = echarts.init(document.getElementById('graph5'));

option = {

    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        },
        formatter:function (params) {
            return  false;
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: ['13、x品牌','12、x品牌','11、OPPO','10、x品牌','9、x品牌','8、x品牌','7、x品牌','6、x品牌','5、三星','4、小米','3、魅族','2、华为','1、苹果']
    },
    series: [
        {
            name: 'PC端',
            type: 'bar',
            data: [98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98],
            itemStyle:{
                normal: {
                    color:'rgb(122,197,167)'
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'right',
                    formatter: '{c} %'
                }
            }
        },
        {
            name: '移动端',
            type: 'bar',
            data: [76, 76, 76, 76, 76, 76,76,76,76,76,76,76,76],
            itemStyle:{
                normal: {
                    color:'rgb(227,168,160)'
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'right',
                    formatter: '{c} %'
                }
            }
        }
    ]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

myChart = echarts.init(document.getElementById('graph6'));
option = {
    tooltip : {
        trigger: 'axis'
    },
    xAxis: {
        data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
    },
    yAxis: {
        name:'关注指数'
    },
    series: [{
        name: '平均值',
        type: 'line',
        data:[220, 182, 191, 234, 290, 330, 310],
        itemStyle:{
            normal: {
                color:'yellow'
            }
        },
    }]
};
myChart.setOption(option);
