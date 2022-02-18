///<reference types="Cypress"/>

context("XML HTTP REQUEST -XHR",()=>{
  
    
  
    const requestUrl ='https://jsonplaceholder.cypress.io/posts'

    it("XHR example 2 - Post",async()=>{  //await kullanmak icin async kullanmaliyiz 

        var response=await cy.request('POST',requestUrl,{
            "userId": 549,
            "title": "cypress test post",
            "body" :"post request body"
        });
      
        console.log(response)
        expect(response.status).to.eq(201)



        //2.yol
        cy.request('POST',requestUrl,{
            "userId": 589,
            "title": "cypress test post",
            "body" :"post request body"
        }).then((response)=>{
            console.log(response)
             expect(response.status).to.eq(201)
            expect(response.body.title).to.eq('cypress test post')
            expect(response).property('body').to.contain({'title' : 'cypress test post'},{'userId':589})
            expect(response.body.userId).to.be.a('number')
            expect(response.body).property('userId').to.be.a('number')
            expect(response.body).property('title').to.be.a('string')
           

            
        })

    })

})