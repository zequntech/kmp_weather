//
//  ViewController.swift
//  iosApp
//
//  Created by zequn on 2021/6/10.
//

import UIKit
import WeatherKit

class ViewController: UIViewController {
    @IBOutlet weak var textview: UILabel!
    @IBAction func click(_ sender: UIButton) {
        SDKManager().injector.apiService.fetchWeather { (weather:Weather?, error:Error?) in
            self.textview.text = String(format: "城市：%@\n温度：%@\n天气：%@",
                                        weather!.weatherinfo.city,
                                        weather!.weatherinfo.temp1+"~"+weather!.weatherinfo.temp2,
                                        weather!.weatherinfo.weather
            )
        }
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        self.textview.numberOfLines = 0
    }
    
    
}

