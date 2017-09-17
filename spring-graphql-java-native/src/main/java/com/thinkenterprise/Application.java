/*
 * Copyright (C) 2016 Thinkenterprise
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *
 * @author Michael Schaefer
 */



package com.thinkenterprise;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

import java.io.File;

import graphql.ExecutionResult;

public class Application {
	
	
	public static void main(String[] args) {
		
		// Big Picture: Build the a GraphQl Schema SDL, IDL  
		// Create a Parser 
		SchemaParser schemaParser = new SchemaParser();
		
		//File file = new File("schema.graphqls");
		File file = new File(ClassLoader.getSystemResource("schema.graphqls").getFile());
		
		// Parse the SDL in a java type representation  
		TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(file);
		
		
		// Big Picture : Build Schema Resolver and Data Fetcher 
		RuntimeWiring runtimeWiring = newRuntimeWiring().type("Message", builder -> builder.dataFetcher("text", new StaticDataFetcher("Hello World"))).build();
		
		// Bring both together an schema an schema resolver with data fetcher an build an executable qraphql schema  
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		
		// Big Picture : Finally build the graph GraphQl Engine 
		GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
		
		ExecutionResult executionResult = graphQL.execute("query {text}");
		
		System.out.println(executionResult.getData().toString());
		
	}
	
	
	
		

}
