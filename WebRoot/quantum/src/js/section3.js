/**
 * Created by zhangxingxing on 2016/12/29.
 */
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('graph9'));


var option = {
    //
    // tooltip: {
    //     trigger: 'axis',
    //     axisPointer: {
    //         type: 'shadow'
    //     }
    // },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        // type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: ['6、内存','5、界面','4、尺寸','3、颜色','2、品牌','1、价格']
    },
    series: [
        {
            name: '',
            type: 'bar',
            data: [7, 8, 11, 15, 24, 35],
            barWidth:35,
            itemStyle:{
                normal: {
                    color:'rgb(122,197,167)',
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

myChart = echarts.init(document.getElementById('graph10'));


option = {

    // tooltip: {
    //     trigger: 'axis',
    //     axisPointer: {
    //         type: 'shadow'
    //     }
    // },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        // type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: ['6、内存','5、界面','4、尺寸','3、颜色','2、品牌','1、价格']
    },
    series: [
        {
            name: '',
            type: 'bar',
            data: [7, 8, 11, 15, 24, 35],
            barWidth:35,
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
        }
    ]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

myChart = echarts.init(document.getElementById('graph11'));

option = {

    // tooltip: {
    //     trigger: 'axis',
    //     axisPointer: {
    //         type: 'shadow'
    //     }
    // },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        // type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: ['6、内存','5、界面','4、尺寸','3、颜色','2、品牌','1、价格']
    },
    series: [
        {
            name: '',
            type: 'bar',
            data: [7, 8, 11, 15, 24, 35],
            itemStyle:{
                normal: {
                    color:'rgb(122,197,167)'
                }
            },
            barWidth:35,
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