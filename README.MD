* Curl:

API ghi nhận cuộc gọi

curl --location --request PUT 'localhost:8080/api/mobile/test_v1/call' \
--header 'Content-Type: application/json' \
--data '{
"call_duration": 21
}'


API hóa đơn:

curl --location 'localhost:8080/api/mobile/test_v1/billing'