local val = redis.call('get', KEYS[1])
if val == false
then
	redis.call('SETEX', KEYS[1], ARGV[1], ARGV[2])
	return true
end
return false
