const interval = 6000;

showClock()
setInterval(showClock, interval);
showDateTime()
setInterval(showDateTime, interval);

function showClock(){

    const date = new Date();

    const hour = ((date.getHours() + 11) % 12 + 1) * 30;
    const minute = date.getMinutes() * 6;
    const second = date.getSeconds() * 6;

    $('.hour').css('transform', `rotate(${hour}deg)`);
    $('.minute').css('transform', `rotate(${minute}deg)`);
    $('.second').css('transform', `rotate(${second}deg)`);
}


    function toNormalDigit(digit){
        const string = digit.toString();
        if (string.length === 1) {
            return `0${string}`;
        }
        return string;
    }





function showDateTime(){

    let days = [
        'Sunday',
        'Monday',
        'Tuesday',
        'Wednesday',
        'Thursday',
        'Friday',
        'Saturday',
    ];

    let months = [
        'January',
        'February',
        'March',
        'April',
        'May',
        'June',
        'July',
        'August',
        'September',
        'October',
        'November',
        'December',
    ];

    const date = new Date();

    let hours = date.getHours();
    const period = hours >= 12 ? 'PM' : 'AM';

    if (hours === 0) hours = 12;
    if (hours > 12) hours = hours - 12;

    $('#day-name').text(days[date.getDay()]);
    $('#month').text(months[date.getMonth()]);
    $('#day-number').text(toNormalDigit(date.getDate()));
    $('#year').text(date.getFullYear());
    $('#hour').text(toNormalDigit(hours));
    $('#minutes').text(toNormalDigit(date.getMinutes()));
    $('#seconds').text(toNormalDigit(date.getSeconds()));
    $('#period').text(period);
}
