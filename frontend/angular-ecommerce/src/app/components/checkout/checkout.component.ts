import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ImpactaFormService } from 'src/app/services/impacta-form.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {


  checkoutFormGroup: FormGroup;

  totalPrice: number = 0;
  totalQuantity: number = 0;


  creditCardMonths: number[] = [];
  creditCardYears: number[] = [];


  constructor(private formBuilder: FormBuilder,
    private impactService: ImpactaFormService
  ) { }

  ngOnInit(): void {

    this.checkoutFormGroup = this.formBuilder.group({
        customer: this.formBuilder.group({
          firstName: [''],
          lastName: [''],
          email: ['']
        }),
        shippingAddress: this.formBuilder.group({
          street: [''],
          city: [''],
          state: [''],
          country: [''],
          zipCode: ['']
        }),
        billingAddress: this.formBuilder.group({
          street: [''],
          city: [''],
          state: [''],
          country: [''],
          zipCode: ['']
        }),
        creditCard: this.formBuilder.group({
          cardType: [''],
          nameOnCard: [''],
          cardNumber: [''],
          securityCode: [''],
          expirationMonth: [''],
          expirationYear: ['']
        }),
    });

    const startMonth: number = new Date().getMonth() + 1;

    this.impactService.getCreditCardMonths(startMonth).subscribe(
      data => {
        console.log("Expiration Months: ", JSON.stringify(data))
        this.creditCardMonths = data;
      }
    )


    this.impactService.getCreditCardYears().subscribe(
      data => {
        console.log("Expiration Years: " , JSON.stringify(data))
        this.creditCardYears = data;
      }
    )
  }


  onSubmit() {
    console.log("Handling the submit button")
    console.log(this.checkoutFormGroup.get('customer').value)
    console.log(this.checkoutFormGroup.get('shippingAddress').value)
    console.log(this.checkoutFormGroup.get('billingAddress').value)
    console.log(this.checkoutFormGroup.get('creditCard').value)
  }

  copyShippingAddressToBillingAddress(event) {
      if (event.target.checked) {
        this.checkoutFormGroup.get("billingAddress")
        .setValue(this.checkoutFormGroup.get("shippingAddress").value);
      } else {
        this.checkoutFormGroup.get('billingAddress').reset();
      }
  }

}
