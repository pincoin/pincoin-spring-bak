package kr.pincoin.api.notification.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/line-notify")
@CrossOrigin("*")
@Slf4j
public class LineNotifyController {
    /*
    @shared_task
def send_notification_line(message):
    url = 'https://notify-api.line.me/api/notify'
    payload = {'message': message}
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Cache-Control': 'no-cache',
        'Authorization': 'Bearer ' + settings.LINE_NOTIFY_ACCESS_TOKEN,
    }
    requests.post(url, data=payload, headers=headers)
     */
}
