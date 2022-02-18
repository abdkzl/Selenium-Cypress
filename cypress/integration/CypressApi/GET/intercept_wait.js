///<reference types="Cypress"/>

context("XML HTTP REQUEST -XHR",()=>{
  
    
  
    const url ='https://example.cypress.io/commands/waiting'
    //io'ya kadar server url              //endpoint ///query parametre

    it("XHR example 2 - wait",()=>{

        cy.visit(url)
       
        //api cagrisini onceden tanimlamak icin 
        //sonra apiyi tetikliyoruz
      

        cy.get(".btn.btn-primary.network-btn").click()

        cy.intercept('GET','**/comments/*').as('getComment')
        
        cy.wait('@getComment').its('response').then((response)=>{
            //intercept ile dinleyemeye aldigimiz api'yi bekleyecek
            console.log(response)
        })

        })

    })
