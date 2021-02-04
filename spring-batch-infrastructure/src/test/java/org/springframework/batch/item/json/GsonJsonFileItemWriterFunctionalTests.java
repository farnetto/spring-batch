/*
 * Copyright 2018-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.batch.item.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.batch.item.json.domain.Trade;

/**
 * @author Mahmoud Ben Hassine
 */
public class GsonJsonFileItemWriterFunctionalTests extends JsonFileItemWriterFunctionalTests {

	@Override
	protected JsonObjectMarshaller<Trade> getJsonObjectMarshaller() {
		return new GsonJsonObjectMarshaller<>();
	}

	@Override
	protected JsonObjectMarshaller<Trade> getJsonObjectMarshallerWithPrettyPrint() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		GsonJsonObjectMarshaller<Trade> jsonObjectMarshaller = new GsonJsonObjectMarshaller<>();
		jsonObjectMarshaller.setGson(gson);
		return jsonObjectMarshaller;
	}

	@Override
	protected String getExpectedPrettyPrintedFile() {
		return "expected-trades-gson-pretty-print.json";
	}

	@Override
	protected String getMarshallerName() {
		return "gson";
	}

}
