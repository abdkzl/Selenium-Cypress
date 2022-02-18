///<reference types="Cypress"/>

context("XML HTTP REQUEST -XHR",()=>{
  
    
  
    const requestUrl ='https://jsonplaceholder.cypress.io/comments'

    it("XHR example",()=>{
    
        cy.request(requestUrl).should((response)=>{
        console.log(response)
        cy.request(requestUrl).as('response')


        assert.equal(response.status,200)
        assert.equal(response.statusText,'OK')
       // expect(response.body).to.have.property('length').to.eq(500)
        expect(response.body).to.have.property('length').and.be.oneOf([499,501,500])
        expect(response.body).to.have.length(500)

        expect(response).to.have.property('headers')
        expect(response).to.have.property('duration')
        })
        
        

   
    })

})


