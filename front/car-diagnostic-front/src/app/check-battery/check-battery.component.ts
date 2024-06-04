import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Chart } from 'chart.js/auto';
import { BreakdownService, GraphData } from '../services/breakdown.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-check-battery',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './check-battery.component.html',
  providers: [BreakdownService],
  styleUrl: './check-battery.component.css'
})
export class CheckBatteryComponent implements AfterViewInit{

  data: GraphData[] = [];
  chartData: {x: number, y: number}[] = [];

  constructor(private breakdownService: BreakdownService) { }

  // ngOnInit(): void {
  //   this.createGraph();
  // }

  ngAfterViewInit(): void {
    this.createGraph();
    this.loadReadings(); // Fetch data and update the chart
  }

  loadReadings(){
    this.breakdownService.checkBattery(1) .subscribe(
      (response) => {
        // Handle the successful response
        // this.data = response.currentReadings;
        this.chartData = response.currentReadings.map(item => ({
          x: new Date(item.startTime).getTime(),
          y: item.value
        }));
      },
      (error) => {
        // This block will only execute if catchError is used
        console.error('Error handler:', error);
      }
    );
  }

  createGraph() {
    this.data = [{
      startTime: "2024-06-04T22:46:04.496+00:00",
      value: 0.0,
      batteryId: 1,
      currentSOC: -1.4125317903387618,
      currentCharge: -1.0235729166666916
    }];

    this.chartData = this.data.map(item => ({
      x: new Date(item.startTime).getTime(),
      y: item.value
    }));

    const ctx = document.getElementById('myChart') as HTMLCanvasElement;
    // const ctx = this.myChart.nativeElement.getContext('2d');
    new Chart(ctx, {
      type: 'line',
      data: {
        datasets: [{
          label: 'Value',
          data: this.chartData,
          borderColor: 'rgb(75, 192, 192)',
          tension: 0.1
        }]
      },
      options: {
        scales: {
          x: {
            time: {
              unit: 'minute'
            },
            title: {
              display: true,
              text: 'Start Time'
            }
          },
          y: {
            title: {
              display: true,
              text: 'Value'
            }
          }
        }
      }
    });
  }
}
