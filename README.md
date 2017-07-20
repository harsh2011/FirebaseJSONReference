# FirebaseJSONReference
Library to get JSON Reponse of the given reference

Details need in Release 0.1.1

Firebase URL: "https://example.firebaseio.com"
  	
Reference URL: "/data/value"

User Token: Auth token from Firebase

How to get Auth token

     FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
            mUser.getIdToken(true)
                    .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                        public void onComplete(@NonNull Task<GetTokenResult> task) {
                            if (task.isSuccessful()) {
                                String token = task.getResult().getToken();
                                // Send token to your backend via HTTPS
                                // ...
                            } else {
                                // Handle error -> task.getException();
                            }
                        }
                    });
                    

# Add Dependencies

Add following to your root build.gradle at the end of repositories:

    allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
    }

Add following dependency

    dependencies {
	        compile 'com.github.harsh2011:FirebaseJSONReference:0.1.1'
	  }
    
# Demo of Library

How to code

    FirebaseJSONReference firebaseJSONReference = new FirebaseJSONReference(MainActivity.this);
        firebaseJSONReference.setFirebaseDatabaseURL("https://example.firebaseio.com");
        firebaseJSONReference.setFirebaseRef("/requestlist");
        firebaseJSONReference.setAuth("auth token");
        firebaseJSONReference.setResponseListener(new ResponseListener() {
            @Override
            public void onResponse(String s) {
                System.out.println("response:"+s);
                try {
                    //JSONobject response 
                    JSONObject main = new JSONObject(s);
                   
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        //build the request
        firebaseJSONReference.build();
        //execute the request and get response in Response Listener
        firebaseJSONReference.execute();
        
# Author
By Harsh Patel, harsh20111997@gmail.com
# License
    Copyright (C) 2017 Harsh Patel

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
