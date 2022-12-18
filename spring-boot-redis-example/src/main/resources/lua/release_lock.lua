local val = redis.call('get', KEYS[1])
if val == false
then
	return true
end
if val == ARGV[1]
then
	redis.call('del', KEYS[1])
	return true
end
return false
